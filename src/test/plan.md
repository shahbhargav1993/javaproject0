Hospital management console app
 pateient record management
  -we will add, view, update patient details /records.

USers: doctor, admiistrators, desk/reception staff

Models:
-patient recdord class with field ID,name, diagnosis or relavant info

service : service class will handle the business logic/plan
main class: it will control the flow and intereact with the user
override: it is used to indicate that the method marked with it is intended to override a method declared
in superclas.in this case we need to folow object class. 
tostring: this method is used to provide meaningful string representation of an
object. this method is a method of object class and by making it with override/ we are providing 
implementation for this method with pateitnrecord class. we are using tostring method with override, 
to create a string that include relvant details like patient id, ful name, age, diagnosis/ this make
it easier to display and log info for patientrecord objects. it is used for debugging,logging, display info for an object.
