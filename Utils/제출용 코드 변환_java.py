import clipboard

def conversion(lines):
    new_codes = []
    comm = False
    for line in lines:
        line = line.rstrip()
        if r"/*" in line or r"*/" in line:  # 여러 줄 주석 토글
            comm = not comm
            continue
        if comm:  # 여러 줄 주석은 넘어감
            continue
        if line == '' or line == '\n':  # 빈 줄
            continue
        if "    static String INPUT" in line:  # txt 파일 호출 제거
            continue
        if "br = new BufferedReader(new FileReader(INPUT));" in line:
            continue
        if r'//' in line:
            if "br = new BufferedReader(new InputStreamReader(System.in));" in line:
                line = line.replace("//", "")
            else:
                continue
        if line.startswith("}"):
            new_codes.append("}")
            break
        line += '\n'
        new_codes.append(line)
    output = ''.join(new_codes)
    if output[-1] == '\n':
        output = output[:-1]
    return output

# 풀이 파일을 읽어서 한줄씩 리스트에 넣음.
file_path = '../Main.java'
with open(file_path, 'r', encoding='utf-8') as file:
    input_code = [line.rstrip() for line in file]
# 스키마 쿼리를 변환하고 클립보드에 복사함.
clipboard.copy(conversion(input_code))
