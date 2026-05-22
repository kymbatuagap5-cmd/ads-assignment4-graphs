import re

s = "hello world"

print(re.search(r'world$', s).group())