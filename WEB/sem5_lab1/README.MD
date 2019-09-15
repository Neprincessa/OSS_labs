# Hash files
***
# Description
This program has an opportunity to hash contents of selected files by md5 or sha256. It works in interactive and manual modes.
1. Interactive mode
    In this mode user can do several times hashing files by md5 or sha256.
2. Manual mode
    In manual mode user choose the type of hash and put in the filename.
***
# How to compile
You can do in in terminal:
```
find . -name '*.java' > source.txt
cat source.txt 
javac -classpath ./lib/commons-io-2.6.jar:./lib/commons-codec-1.4.jar -d build @source.txt
vim MANIFEST.MD 
cd build/
jar cvfm ../bin/HashFunc.jar ../MANIFEST.MD * ../lib/
cd ..
cd bin/
```
Or run ```./compileFile```
***
# How to use
Write in terminal, if you want to run interactive mode:
```
java -jar HashFunc.jar -i
```
And this command, if you want to run manual mode (instead flag ```-md5``` user can use ```-sha256```)
```
java -jar HashFunc.jar -md5 -f test.txt 
```
 
