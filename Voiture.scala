
// Exo sur la class Vehicule

sealed abstract class Vehicule(){}
case class Car() extends Vehicule(){}
case class Motorbike() extends Vehicule(){}
case class Boat() extends Vehicule(){}

// Exo sur la filiale Peugeot

sealed abstract class Peugeot(){
  val model : String
}

abstract class Vehicule() extends Peugeot(){}
case class Car(model:String) extends Vehicule(){}
case class Motorbike(model:String) extends Vehicule(){}
case class Boat(model:String) extends Vehicule(){}
case class Bike(model:String) extends Vehicule(){}

abstract class ElectricalGood() extends Peugeot(){}
case class CoffeeMachine(model:String) extends ElectricalGood(){}

// Exo sur la carte bancaire

sealed abstract class BrandingName() {}

case object Amex extends BrandingName() {
  object Digits {
    def unapply(s: String, l: Int): Option[Int] {
      if (s.length() == l) {
        util.try {s.toInt}.toOption
      } else {
        None
      }
    }
  }
}