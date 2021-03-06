package com.samiu.wangank.ui.square

import com.samiu.wangank.http.BaseWanRepository
import com.samiu.wangank.http.WanClient

/**
 * @author Samiu 2020/3/5
 * @github https://github.com/SamiuZhong
 * @blog samiu.top
 */
class WanSquareRepository : BaseWanRepository() {

    suspend fun getSquareArticle(page: Int) = readyCall{
        call(WanClient.service.getSquareArticleList(page))
    }
}