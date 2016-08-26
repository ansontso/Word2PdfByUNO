# Word2PdfByUNO

### 1. 需要用的软件

    OpenOffice 下载地址http://www.openoffice.org/

    JodConverter 下载地址http://sourceforge.net/projects/jodconverter/files/JODConverter/，也可以直接从附件里面下载



### 2.启动OpenOffice的服务

    我到网上查如何利用OpenOffice进行转码的时候，都是需要先用cmd启动一个soffice服务，启动的命令是：soffice -headless -accept="socket,host=127.0.0.1,port=8100;urp;"。

    但是实际上，对于我的项目，进行转码只是偶尔进行，然而当OpenOffice的转码服务启动以后，该进程(进程名称是soffice.exe)会一直存在，并且大约占100M的内存，感觉非常浪费。于是我就想了一个办法，可以将执行该服务的命令直接在JAVA代码里面调用，然后当转码完成的时候，直接干掉这个进程。在后面的JAVA代码里面会有解释。

    所以，实际上，这第2步可以直接跳过



### 3.将JodConverter相关的jar包添加到项目中

    将JodConverter解压缩以后，把lib下面的jar包全部添加到项目中
