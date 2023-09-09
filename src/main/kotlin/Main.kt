import java.util.*

fun main() {
    val arr = intArrayOf(1, 2, 6, 10, 25, -8, 0, 4)
    println("Исходный массив:")
    printArray(arr)
    println("Отсортированный массив императивно: ")
    printArray(sort_list_imperative(arr))
    println("Отсортированный массив декларативно: ")
    arr.sortDescending()//Преподаватель подсказал Collections.sort(numbers, Collections.reverseOrder()) 
    printArray(arr)
    println("Задача на поиск одиночки: ")
    val arrayWithDuplicates = arrayOf(4, 3, 2, 4, 1, 3, 2)
    println(arrayWithDuplicates.joinToString())
    val listOfSingletons = findSingletons(arrayWithDuplicates)
    println("в единственном числе встречается:  ${listOfSingletons}")
    val mixtArray = arrayOf(2, 3, 1, 5, 3)
    println(mixtArray.joinToString())
    val missing = findMissing(mixtArray)
    println("Пропущены числа: ${missing}")
    val twins = findTwins(mixtArray)
    println("Дважды встечаются элементы: ${twins}")
}

/* Задача №1
Дан список целых чисел numbers. Необходимо написать в императивном стиле процедуру для
сортировки числа в списке в порядке убывания. Можно использовать любой алгоритм сортировки
*/

fun printArray(nums: IntArray) {
    for (item in nums) {
        print("${item} ")
    }
    println()
}

fun sort_list_imperative(numbers: IntArray): IntArray {
    var isSorted = false
    while (!isSorted) {
        isSorted = true
        for (index in 0..(numbers.size - 2)) {
            if (numbers[index] < numbers[index + 1]) {
                val temp = numbers[index + 1]
                numbers[index + 1] = numbers[index]
                numbers[index] = temp
                isSorted = false
            }
        }
    }
    return numbers
}


// Задача №2 Написать точно такую же процедуру, но в декларативном стиле


//fun sort_list_declarative(numbers: IntArray): Array<Int> {
//    // return numbers.sorted().reversed().forEach { print("${it} ") } тоже работает
//}


/* Задача 3: У вас есть массив целых чисел, в котором каждое число, кроме одного, повторяется
дважды.Вам нужно найти это одиночное число . Пример
Входной массив :[4, 3, 2, 4, 1, 3, 2]
Результат: 1
В данной задаче вы должны найти способ найти одиночное число с использованием массивов
и алгоритмов/ */

fun findSingletons(arr: Array<Int>): Set<Int> {
    val temp = discribtionByQuantity(arr).filter { it.value==1 }
    return temp.keys
}

fun discribtionByQuantity(array: Array<Int>): Map<Int, Int> {
    val myMutableMap = mutableMapOf(0 to 0)
    myMutableMap.clear()
    for (item in array) {
        myMutableMap.put(item, myMutableMap.getOrDefault(item, 0) +1)
    }
    return myMutableMap
}

fun findTwins(arr: Array<Int>): Set<Int> {
    val temp = discribtionByQuantity(arr).filter { it.value==2 }
    return temp.keys
}

fun findMissing(arr: Array<Int>): List<Int> {
    val myList = mutableListOf(4)
    myList.clear()
    val begin = arr.min()
    val end = arr.max()
    for (x in begin .. end) {
        if (!arr.contains(x)) {
            myList.add(x)
        }
    }
    return myList
}


/* Задача 4: У вас есть массив, содержащий числа от 1 до N, где N-длина массива.
Одно из чисел в массиве повторяется дважды, а одно число пропущено.
Найдите повторяющееся число и пропущенное число .
Пример:
Входной массив :[2, 3, 1, 5, 3]
Повторяющееся число : 3
Пропущенное число : 4
*/
