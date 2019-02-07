package nevigation.example.com.nevigationdemo.camera


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import nevigation.example.com.nevigationdemo.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CameraFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_camera, container, false)

        //lazy property
        /*val lazyValue: String by lazy {
            println("computed!")
            "Hello"
        }

        println("lazy1: $lazyValue")
        println("lazy2: $lazyValue")*/

        //properties in map
        /*val user = User(mapOf(
                "name" to "John Doe",
                "age"  to 25
        ))
        println("""properties in map1: ${user.name}""") // Prints "John Doe"
        println("""properties in map1: ${user.age}""")*/

        C().caller(D())   // prints "D.foo in C"
        C1().caller(D())  // prints "D.foo in C1" - dispatch receiver is resolved virtually
        C().caller(D1())

        return view
    }

    open class D { }

    class D1 : D() { }

    open class C {
        open fun D.foo() {
            println("D.foo in C")
        }

        open fun D1.foo() {
            println("D1.foo in C")
        }

        fun caller(d: D) {
            d.foo()   // call the extension function
        }
    }

    class C1 : C() {
        override fun D.foo() {
            println("D.foo in C1")
        }

        override fun D1.foo() {
            println("D1.foo in C1")
        }
    }
    //properties in map
    class User(val map: Map<String, Any?>) {
        val name: String by map
        val age: Int     by map
    }

}
