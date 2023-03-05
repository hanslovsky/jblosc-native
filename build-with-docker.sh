#!/usr/bin/env sh

image_name=$1
[ -n "$image_name" ] || (echo image not provided; exit 1)

ls c-blosc
target=/app/c-blosc
docker run --entrypoint='' -v $PWD/c-blosc:$target "$image_name" bash -c "cd $target; rm -rf build; mkdir build; cd build; ls -halF $target; cmake -DCMAKE_INSTALL_PREFIX=/app -DCMAKE_BUILD_TYPE=Release $target; make -j8"
