package com.hanslovsky.jblosc_native

import org.blosc.JBlosc
import org.junit.Assert
import org.junit.Test
import java.nio.ByteBuffer

class LoadBloscTest {

    @Test fun runBlosc() {
        val blosc = JBlosc()
        val destSize = blosc.compress(
            0,
            0,
            1,
            ByteBuffer.allocate(1),
            1L,
            ByteBuffer.allocate(1 + JBlosc.OVERHEAD),
            1L + JBlosc.OVERHEAD
        )
        Assert.assertTrue(destSize > 0)
    }
}