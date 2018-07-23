package com.uni7corn.uplayer.builder

import com.uni7corn.uplayer.base.BaseSourceData

/**
 * Created by sm
 *
 * on 2018/7/23
 *
 * desc:
 *
 */
class SourceDataBuilder {

    private var id = 0
    private var title: String? = null
    private var url: String? = null
    private var vid: String? = null

    fun setId(id: Int): SourceDataBuilder {
        this.id = id
        return this
    }

    fun setTitle(title: String?): SourceDataBuilder {
        this.title = title
        return this
    }

    fun setUrl(url: String?): SourceDataBuilder {
        this.url = url
        return this
    }

    fun setVid(vid: String?): SourceDataBuilder {
        this.vid = vid
        return this
    }

    fun build(): BaseSourceData {
        val baseSourceData = BaseSourceData()
        baseSourceData.id = id
        baseSourceData.title = title
        baseSourceData.url = url
        baseSourceData.vid = vid
        return baseSourceData
    }
}