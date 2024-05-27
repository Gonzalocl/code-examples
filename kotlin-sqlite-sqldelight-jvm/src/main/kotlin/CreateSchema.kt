package org.eu.gonzalocaparros

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver

fun main() {
    val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:db.sqlite")
    Database.Schema.create(driver)
}
