package day3

import java.awt.Point
import kotlin.math.sqrt

class Shematic(input: List<String>) {
    val mapSize: Point
    val numbers: List<Num>
    val symbols: List<Symbol>

    init {
        mapSize = Point(input[0].length, input.size)
        numbers = input.withIndex().map { findNumbersInRow(it.value, it.index) }.flatten()
        symbols = input.withIndex().map { findSymbolsInRow(it.value, it.index) }.flatten()
    }


    private fun findNumbersInRow(row: String, yAxis: Int): List<Num> {
        return Regex("(\\d+)").findAll(row)
            .map { it.range to it.value }
            .map { Num(it.second.toInt(), Point(it.first.first, yAxis), Point(it.first.last, yAxis)) }
            .toList()
    }

    private fun findSymbolsInRow(row: String, yAxis: Int): List<Symbol> {
        return Regex("[^a-zA-Z0-9.\\n\\r]").findAll(row)
            .map { it.range to it.value }
            .map { Symbol(it.second, Point(it.first.first, yAxis)) }
            .toList()
    }

    fun getPartNumbers(): List<Num> {
        return numbers.filter { symbols.firstOrNull { s -> isAdjacent(it, s) } != null }
    }

    private fun isAdjacent(n: Num, s: Symbol): Boolean {
        return getDistOk(n.coordDebut, s.coord) || getDistOk(n.coordFin, s.coord)
    }

    private fun getDistOk(p1: Point, p2: Point): Boolean {
        val px: Double = p1.getX() - p2.getX()
        val py: Double = p1.getY() - p2.getY()
        val x = sqrt(px * px).toInt()
        val y = sqrt(py * py).toInt()
        return x <= 1 && y <= 1
    }

    fun getGears(): List<Gear> {
        return symbols.filter { it.id.equals("*") }
            .map { s -> numbers.filter { isAdjacent(it, s) } }
            .filter { it.size == 2 }
            .map { Gear(it[0].id * it[1].id) }
    }
}

data class Gear(val value: Int)
data class Num(val id: Int, val coordDebut: Point, val coordFin: Point)
data class Symbol(val id: String, val coord: Point)
