package by.limitAlltheir.myapplication

val sortsOfCoffee = arrayListOf<CoffeeCollection>()

data class CoffeeCollection(
    var name: String,
    var url: String,
    var price: Double
)

fun addToCollection(cc: CoffeeCollection) {
    sortsOfCoffee.add(cc)
}