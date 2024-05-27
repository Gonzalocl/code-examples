package org.eu.gonzalocaparros

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.eu.gonzalocaparros.sqldelight.tracks.data.Map

fun main() {
    val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:db.sqlite")
    val database = Database(driver)
    val mapQueries = database.mapQueries

    println(mapQueries.selectAll().executeAsList())

    val map = Map(1, "Map #0", "Map description")
    mapQueries.insert(map)

    mapQueries.insertName(id = 0, name = "Map #1")
    println(mapQueries.selectAll().executeAsList())

    mapQueries.insertDescription(id = 0, description = "Map description edited")
    println(mapQueries.selectAll().executeAsList())

}
