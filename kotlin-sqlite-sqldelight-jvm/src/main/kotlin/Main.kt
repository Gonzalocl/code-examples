package org.eu.gonzalocaparros

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.eu.gonzalocaparros.sqldelight.hockey.data.Map

fun main() {
    val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:db.sqlite")
    Database.Schema.create(driver)

    val database = Database(driver)
    val trackQueries = database.trackQueries

    println(trackQueries.selectAll().executeAsList())

    trackQueries.insert(id = 0, name = "Map #0")
    println(trackQueries.selectAll().executeAsList())

    val map = Map(1, "Map #1")
    trackQueries.insertFullMapObject(map)

}
