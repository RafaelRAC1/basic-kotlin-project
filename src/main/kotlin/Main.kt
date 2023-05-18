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

fun main(){
    //Creating users
    val userRafael = User("Rafael", 18)
    val userToya = User("Toya", 3)

    //Creating courses and their contents
    val javaCourse = Course("Java Basics", Level.EASY)
    javaCourse.registerContent(Content("Variables", 10))

    val kotlinCourse = Course("Kotlin Basics", Level.EASY)
    kotlinCourse.registerContent(Content("Data Types", 5))

    //Registering users into courses
    userRafael.registerIntoCourse(javaCourse)
    userRafael.registerIntoCourse(kotlinCourse)

    userToya.registerIntoCourse(kotlinCourse)

    //Using a function to insert multiple contents into a course
    javaCourse.registerMultipleContent(
        Content("Conditionals", 7),
        Content("Data Structures", 20)
    )
    kotlinCourse.registerMultipleContent(
        Content("Variables", 5),
        Content("Data Structures", 20)
    )

    //Print the info
    println("-----------Users Info-------------")
    println("Courses attended by "+userRafael.name+":\n"
            +userRafael.getAttendedCourses())
    println()
    println("Courses attended by "+userToya.name+":\n"
            +userToya.getAttendedCourses())
    println("------------------------------------")
    println()

    println("-----------Courses Info-------------")
    println("Course: "+javaCourse.name+"\n"
            +"Registered Users: "
            +javaCourse.getRegisteredUsers()+"\n"
            +"Registered Contents: "
            +javaCourse.getRegisteredContents())
    println()
    println("Course: "+kotlinCourse.name+"\n"
            +"Registered Users: "
            +kotlinCourse.getRegisteredUsers()+"\n"
            +"Registered Contents: "
            +kotlinCourse.getRegisteredContents())
    println("------------------------------------")

}