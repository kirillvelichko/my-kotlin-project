package my.project.service.utils

import my.project.data.model.User
import my.project.gen.jaxb.GetUserResponse

fun convertGetUserResponseToUser(getUserResponse: GetUserResponse): User {
    val userSchema = getUserResponse.user
    return User(userSchema.id, userSchema.login, userSchema.password)
}