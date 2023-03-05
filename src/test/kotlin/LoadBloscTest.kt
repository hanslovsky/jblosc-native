package com.hanslovsky.jblosc.native

import org.blosc.JBlosc
import org.junit.Assert
import org.junit.Test
import org.scijava.nativelib.NativeLoader
import java.io.IOException
import java.nio.ByteBuffer

class LoadBloscTest {

    @Test fun loadBlosc() = NativeLoader.loadLibrary("blosc")
    @Test fun failLoadLibrary(): Unit = Assert.assertThrows(IOException::class.java) { NativeLoader.loadLibrary("csolb") }.let {  }
    @Test fun runBlosc() {
        loadBlosc()
        val blosc = JBlosc()
        blosc.compress(
            0,
            0,
            1,
            ByteBuffer.allocate(1),
            1L,
            ByteBuffer.allocate(1 + JBlosc.OVERHEAD),
            1L + JBlosc.OVERHEAD
        )
    }
}