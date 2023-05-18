data class User(val name: String, val age: Int){
    private val attendedCourses = mutableListOf<Course>()

    fun registerIntoCourse(course: Course){
        attendedCourses.add(course)
        course.getRegisteredUsers().add(this)
    }

    fun getAttendedCourses(): List<Course>{
        return attendedCourses
    }
}

enum class Level { EASY, INTERMEDIATE, ADVANCED}

data class Content(val name: String, val duration: Int)

data class Course(val name: String, val difficulty: Level) {
    private val registeredUsers = mutableListOf<User>()
    private val registeredContents = mutableListOf<Content>()

    fun registerContent(content: Content) {
        registeredContents.add(content)
    }

    fun registerMultipleContent(vararg content: Content) {
        registeredContents.addAll(content)
    }

    fun getRegisteredContents(): List<Content>{
        return registeredContents
    }

    fun getRegisteredUsers(): MutableList<User>{
        return registeredUsers
    }
}

fun main() {
    println("Hello World!")
}