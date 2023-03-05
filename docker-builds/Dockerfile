FROM ubuntu:18.04


RUN apt-get update
RUN yes | apt-get install build-essential wget
RUN wget https://github.com/Kitware/CMake/releases/download/v3.25.2/cmake-3.25.2-Linux-x86_64.sh -O cmake.sh
RUN sh cmake.sh --prefix=/usr/local/ --exclude-subdir
RUN ldd --version
RUN gcc --version
RUN cmake --version

