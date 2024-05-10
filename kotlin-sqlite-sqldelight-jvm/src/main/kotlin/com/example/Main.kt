package com.example

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver

fun main(args: Array<String>) {
    val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:test.db")
    Database.Schema.create(driver)
}
