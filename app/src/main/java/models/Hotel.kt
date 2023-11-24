package models

class Hotel (
    var name: String,
    var city: String,
    var province: String,
    var phone: String
)
{
    override fun toString(): String {
        return "Hotel(name='$name', city='$city', province='$province'," +
                "phone= '$phone'.toString()')"
    }

}