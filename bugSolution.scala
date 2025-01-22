```scala
import scala.concurrent.{ExecutionContext, Future}

class MyClass(implicit ec: ExecutionContext) {
  def myMethod(x: Int): Future[Int] = Future {
    if (x < 0) throw new IllegalArgumentException("x must be non-negative")
    x * 2
  }.recover { 
    case e: IllegalArgumentException => 0 // Or some other default value
    case e: Exception => -1 // Handle other exceptions differently
  }
}

//Alternative solution using recoverWith:
//  def myMethod(x: Int): Future[Int] = Future {
//    if (x < 0) throw new IllegalArgumentException("x must be non-negative")
//    x * 2
//  }.recoverWith { 
//    case e: IllegalArgumentException => Future.successful(0) // Or some other default value
//    case e: Exception => Future.successful(-1) // Handle other exceptions differently
//  }
```