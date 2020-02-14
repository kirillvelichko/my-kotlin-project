package my.project.data.model

data class User(val id: String, var login: String, var password: String) {
    constructor(login: String, password: String) : this("", login, password)
    constructor() : this("", "", "")
}