data class Student(val name: String, val age: Int, val school: String)

fun main(){

    val students = arrayListOf(
        Student("Ahmet" , 20, "Üniversite A"),
        Student("Ayşe"  , 27, "Üniversite B"),
        Student("Mehmet", 22, "Üniversite C"),
        Student("Fatma" , 28, "Üniversite A"),
        Student("Ali"   , 29, "Üniversite B"),
        Student("Feyza" , 24, "Üniversite A"),
        Student("Berkay", 22, "Üniversite B"),
        Student("Caner" , 26, "Üniversite A")
    )

    // En büyük ve en küçük öğrenciyi bulmak ve konsola yazdırmak
    val kucukYas = students.minByOrNull { it.age }
    val buyukYas = students.maxByOrNull { it.age }

    if (kucukYas != null && buyukYas != null) {
        val minIndex = students.indexOf(kucukYas)
        val maxIndex = students.indexOf(buyukYas)

        println("""
            
            En büyük öğrenci ${buyukYas.name} ve indexi $maxIndex
            En küçük öğrenci ${kucukYas.name} ve indexi $minIndex
            
        """.trimIndent())

    }

    // Üniversitesi A olan öğrenciler
    val ogrenciA = students.filter { it.school == "Üniversite A" }
    println("Üniversitesi A olanlar:")
    for (a in ogrenciA) println(a.name)

    val kucuk25 = ogrenciA.filter { it.age < 25 }
    val buyuk25 = ogrenciA.filter { it.age >= 25 }

    println("Yaşı 25'den küçükler: ")
    for (ogrenci in kucuk25){
        println(ogrenci.name)
    }

    println("Yaşı 25'den büyük ve eşit olanlar: ")
    for (ogrenci in buyuk25){
        println(ogrenci.name)
    }


}



