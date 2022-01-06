package jp.medibox.user.ui.main

open class Primary_Constructor_With_Param(param1: Int) {
    val property1: Int = param1
    val property2: Int

    init{
        property2 = 2*param1
    }
}

class Child1(param1: Int) : Primary_Constructor_With_Param(param1){// child's primary constructor must delegate to
    // parent have primary constructor


}

//------------------------------------------

open class Primary_Constructor_With_Property(open var property1: Int) {

}

class Child2(property1: Int) : Primary_Constructor_With_Property(property1) {

}

//------------------------------------------

open class Secondary_Constructor_Without_Primary_Constructor {
    val property1: String // without primary constructor, property (even [var] or [val]) can be initialized at
    // secondary constructor

    constructor(param1: String, param2: String) {
        property1 = param1
    }

}


class Child3 : Secondary_Constructor_Without_Primary_Constructor {
    val property2: String

    constructor(param1: String, param2: String): super(param1, param2) {//child's secondary constructor must delegate to itselft primary constructor
        //or parent's secondary constructor
        this.property2 = param2
    }

}

//------------------------------------------

open class Secondary_Constructor_With_Primary_Constructor(val property1: String) {
    val property2: String
    var property3: String = ""

    init{
        property2 = "" // when have Primary_Constructor, property must initialize in [init block]
        //or declare in primary constructor
        //or at place declare property
    }

    constructor(param1: String, param2: String) : this(param1){ // secondary constructor must delegate to primary constructor
    }
}

class Child4(property1: String) : Secondary_Constructor_With_Primary_Constructor(property1) {

    constructor(param1: String, param2: String): this(param1) {//child's secondary constructor must delegate to itselft primary constructor
        //or parent's secondary constructor

    }

}