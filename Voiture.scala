
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

sealed abstract class BrandingName{}
case object Amex extends brandingName{}
case object Visa extends brandingName{}
case object Mastercard extends brandingName{}

//Custom extractor string, check length and all int at the same time
object DigitsLength { 
  def unapply(s: String, l: Int): Option[Int] = {
      if(s.length() == l){
          util.Try(s.toInt).toOption 
      }else{
          None
      }
  } 
}


class CVC( numbers : String, branding: brandingName){
}
object CVC{
	def apply(numbers: String): Option[CVC] = (numbers, branding) match {
        case (DigitsLength(i, 4), branding: Amex)   => Some(i)
        case (DigitsLength(i, 3),branding: Mastercar ) =>  Some(i)
        case (DigitsLength(i, 3), branding: Visa) =>  Some(i)
        case _ => None
    }
}

class cardNumber( numbers : String, branding: brandingName){
}
object cardNumber{
	def apply(numbers: String): Option[cardNumber] = numbers match {
        case DigitsLength(i, 16) => Some(i)
        case _ => None
    }
}

case class CreditCard(brand: BrandingName, numbers: cardNumber, expirationMonth: Month, expirationYear: Year, cvc: CVC){}