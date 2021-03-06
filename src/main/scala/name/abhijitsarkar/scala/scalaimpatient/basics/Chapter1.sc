package name.abhijitsarkar.scala.scalaimpatient

import scala.math._
import scala.math.BigInt.probablePrime
import scala.util.Random

object Chapter1 {
  /* Q2:                                                                                                                                                           In the Scala REPL, compute the square root of 3, and then square that value.
     By how much does the result differ from 3?
   */
  val sqrtOfThree = sqrt(3)                       //> sqrtOfThree  : Double = 1.7320508075688772
  val squareOfSqrtOfThree = sqrtOfThree * sqrtOfThree
                                                  //> squareOfSqrtOfThree  : Double = 2.9999999999999996
  
  3 - squareOfSqrtOfThree                         //> res0: Double = 4.440892098500626E-16
  
  /* Q3: Are the res variables val or var?
     Ans: The res variables are val.
   */
  
  /* Q4: Scala lets you multiply a string with a number-try out "crazy" * 3 in the REPL. What does this operation do?
     Where can you find it in the Scaladoc?
     Ans: scala.collection.immutable.StringOps.
  */
  "crazy" * 3                                     //> res1: String = crazycrazycrazy
  
  /* Q5: What does 10 max 2 mean? In which class is the max method defined?
     10 max 2 means find out the bigger of the 2 operands, in this case 10 and 2.
     The method max is found in scala.math.Integral.
  */
  10 max 2                                        //> res2: Int = 10
  
  /* Q6: Using BigInt, compute 2^1024 */
  BigInt("2").pow(1024)                           //> res3: scala.math.BigInt = 1797693134862315907729305190789024733617976978942
                                                  //| 306572734300811577326758055009631327084773224075360211201138798713933576587
                                                  //| 897688144166224928474306394741243777678934248654852763022196012460941194530
                                                  //| 829520850057688381506823424628814739131105408272371633505106845862982399472
                                                  //| 45938479716304835356329624224137216
   
  /* Q7: What do you need to import so that you can get a random prime as probablePrime(100, Random),
    without any qualifiers before probablePrime and Random?
    Ans: scala.math.BigInt.probablePrime for probablePrime and scala.util.Random for Random.
  */
   val prime = probablePrime(100, Random)         //> prime  : scala.math.BigInt = 867899254275145659686200955387
   
   /* Q8: One way to create  random file or directory names is to produce a random BigInt and convert it to base 36,
      yielding a string such as "                    qsnvbevtomcj38o06kul". Poke around Scaladoc to find a way of doing this in Scala.
    */
   (prime underlying) toString(36)                //> res4: String = 2c56wu9mhkopy35cqiuz
   
   /* Q9: How do you get the first charcater of a string in Scala? The alst character? */
   val str = "scala"                              //> str  : String = scala
   str.head                                       //> res5: Char = s
   str.last                                       //> res6: Char = a
   
   /* Q10: What do the take, drop, takeRight, and dropRight string functions do? What advantage or disadvantage do they
      have over using substring?
      take(n: int): String -> Selects first n elements.
      takeRight(n: int): String -> Selects last n elements.
      drop(n: int): String -> Selects all elements except first n ones.
      dropRight(n: int): String -> Selects all elements except last n ones.
      
      substring(arg0: Int, arg1: Int): String
      substring(arg0: Int): String
      
      The takeX and dropX methods are guarded against the cases where n is either more than the length of the sequence,
      or less. substring throws an StringIndexOutOfBoundsException for n < 0 or > the length of the sequence.
      So the takeX and dropX methods reduce an extra step on the programmer's part to the check the min of n and
      length before doing substring operations. Also saying "Scala, give me 5 characters from the front, please"
      is easier than messing with a zero-based index and an exclusive last index.
    */
}