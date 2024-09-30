import io
import os
import subprocess
import sys
from contextlib import redirect_stdout, redirect_stderr


def get_result(input_data: str) -> tuple[str, str]:
    # 입력 스트림을 StringIO 객체로 변경
    sys.stdin = io.StringIO(input_data)
    # 출력과 에러 캡처를 위한 StringIO 객체 생성
    output = io.StringIO()
    errors = io.StringIO()

    # Java 파일의 절대 경로 얻기
    script_path = os.path.abspath(script)
    script_dir = os.path.dirname(script_path)

    # Java 파일 컴파일
    compile_process = subprocess.run(['javac', script_path], capture_output=True, text=True)
    if compile_process.returncode != 0:
        return "", compile_process.stderr

    # 컴파일된 Java 클래스 실행
    with redirect_stdout(output), redirect_stderr(errors):
        try:
            run_process = subprocess.run(
                ['java', '-cp', script_dir, 'Main'],
                input=input_data,
                capture_output=True,
                text=True,
                timeout=5
            )
            output.write(run_process.stdout)
            if run_process.returncode != 0:
                error_lines = run_process.stderr.splitlines()
                filtered_error_lines = []
                for line in error_lines:
                    is_not_junit = not line.startswith("\tat org.junit.")
                    is_not_java_base = not line.startswith("\tat java.base/")
                    is_not_boj_judge = "boj_judge.java" not in line
                    if is_not_junit and is_not_java_base and is_not_boj_judge:
                        filtered_error_lines.append(line)
                errors.write("\n".join(filtered_error_lines))
        except subprocess.TimeoutExpired:
            errors.write("Execution timed out after 5 seconds")
        except Exception as e:
            errors.write(f"An error occurred: {str(e)}")

    # 출력값, 에러값을 문자열로 변환
    result = output.getvalue(), errors.getvalue()

    # Main.class 파일 삭제
    class_file = os.path.join(script_dir, 'Main.class')
    if os.path.exists(class_file):
        os.remove(class_file)

    return result


inputdatas = [
    {"data": """8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW""", "answer": """1"""},
    {"data": """10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB""", "answer": """12"""},
    {"data": """8 8
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB""", "answer": """0"""},
    {"data": """9 23
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBW""", "answer": """31"""},
    {"data": """10 10
BBBBBBBBBB
BBWBWBWBWB
BWBWBWBWBB
BBWBWBWBWB
BWBWBWBWBB
BBWBWBWBWB
BWBWBWBWBB
BBWBWBWBWB
BWBWBWBWBB
BBBBBBBBBB""", "answer": """0"""},
    {"data": """8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWWWB
BWBWBWBW""", "answer": """2"""},
    {"data": """11 12
BWWBWWBWWBWW
BWWBWBBWWBWW
WBWWBWBBWWBW
BWWBWBBWWBWW
WBWWBWBBWWBW
BWWBWBBWWBWW
WBWWBWBBWWBW
BWWBWBWWWBWW
WBWWBWBBWWBW
BWWBWBBWWBWW
WBWWBWBBWWBW""", "answer": """15"""}
]

script = "Main.java"

for inputdata in inputdatas:
    data, ans = inputdata["data"], inputdata["answer"]
    output, error = get_result(data)
    output = output.rstrip()  # 개행문자 제거
    if output == ans:  # 정답과 출력값이 같으면 pass
        print("pass")
    else:  # 다르면 fail과 정답, 출력값 출력
        summary = "fail"
        print(f"\nInput: {data}")
        for label, content in [("expected:", ans), ("got:", output), ("Error:", error)]:
            if label == "Error:" and not content:
                continue
            summary += f"\n  {label}\n"
            for line in content.splitlines():
                summary += f"    {line}\n"
            summary = summary.rstrip()
        print(summary)
