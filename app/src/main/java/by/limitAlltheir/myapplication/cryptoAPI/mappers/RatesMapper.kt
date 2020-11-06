package by.limitAlltheir.myapplication.cryptoAPI.mappers

import by.limitAlltheir.myapplication.cryptoAPI.dto.Data
import by.limitAlltheir.myapplication.cryptoAPI.dto.RatesResponse
import by.limitAlltheir.myapplication.cryptoAPI.entity.Rates

class RatesMapper {

    fun map(from: Data) = Rates(
        name = from.name.orEmpty(),
        price = from.quote?.uSD?.price ?: 0.0,
        change = from.quote?.uSD?.percentChange1h ?: 0.0
    )
}