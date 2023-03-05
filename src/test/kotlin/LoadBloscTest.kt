package com.hanslovsky.jblosc.native

import org.junit.Assert
import org.junit.Test
import org.scijava.nativelib.NativeLoader
import java.io.IOException

class LoadBloscTest {

    @Test fun loadBlosc() = NativeLoader.loadLibrary("blosc")
    @Test fun failLoadLibrary(): Unit = Assert.assertThrows(IOException::class.java) { NativeLoader.loadLibrary("csolb") }.let {  }
}