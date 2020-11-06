package by.limitAlltheir.myapplication.cryptoAPI.dto

import com.google.gson.annotations.SerializedName


//e2858da2-c3d7-4f4f-b550-480f93ad01d3
data class RatesResponse(
    @SerializedName("data")
    var dataList: List<Data>? = null,
    @SerializedName("status")
    var status: Status? = null
)

data class Status(
    @SerializedName("credit_count")
    val creditCount: Int? = null,
    @SerializedName("elapsed")
    val elapsed: Int? = null,
    @SerializedName("error_code")
    val errorCode: Int? = null,
    @SerializedName("error_message")
    val errorMessage: Int? = null,
    @SerializedName("notice")
    val notice: Any? = null,
    @SerializedName("timestamp")
    val timestamp: String? = null,
    @SerializedName("total_count")
    val totalCount: Int? = null
)

data class Data(
    @SerializedName("circulating_supply")
    val circulatingSupply: Double?,
    @SerializedName("cmc_rank")
    val cmcRank: Int?,
    @SerializedName("date_added")
    val dateAdded: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("max_supply")
    val maxSupply: Double?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("num_market_pairs")
    val numMarketPairs: Int?,
    @SerializedName("platform")
    val platform: Any?,
    @SerializedName("quote")
    val quote: Quote?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("total_supply")
    val totalSupply: Double?
)

data class Quote(
    @SerializedName("USD")
    val uSD: USD?
)

data class USD(
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("market_cap")
    val marketCap: Double?,
    @SerializedName("percent_change_1h")
    val percentChange1h: Double?,
    @SerializedName("percent_change_24h")
    val percentChange24h: Double?,
    @SerializedName("percent_change_7d")
    val percentChange7d: Double?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("volume_24h")
    val volume24h: Double?
)