//Prateek
//wwww.prateeks.in
//www.justdoelectronics.com
//https://www.youtube.com/c/JustDoElectronics/videos

#include "SoftwareSerial.h"
#include <LiquidCrystal_I2C.h>
#include <SoftwareSerial.h>
SoftwareSerial mySerial(3, 2);
LiquidCrystal_I2C lcd(0x27, 16, 2);

#define blue 2
#define green 3
#define red 4

unsigned int f;
unsigned int g;
unsigned int h;

void setup() {

  pinMode(blue, OUTPUT);
  pinMode(green, OUTPUT);
  pinMode(red, OUTPUT);
  Serial.begin(9600);
  mySerial.begin(9600);
  Serial.println();
  lcd.init();
  lcd.backlight();
  lcd.setCursor(0, 0);
  lcd.print("  Welcome To");
  lcd.setCursor(0, 1);
  lcd.print("JustDoElectronic");
  lcd.clear();
  delay(3000);
}

void loop() {

  f = analogRead(1);
  g = analogRead(2);
  h = analogRead(3);

  //Prateek
  //wwww.prateeks.in
  //www.justdoelectronics.com
  //https://www.youtube.com/c/JustDoElectronics/videos

  // Serial.print("f reading");
  // Serial.println(f);
  // Serial.print("g reading");
  // Serial.println(g);
  // Serial.print("h reading");
  // Serial.println(h);

  if (f <= 722) {
    digitalWrite(blue, HIGH);
    digitalWrite(green, LOW);
    digitalWrite(red, LOW);
    mySerial.println("Plz Give Me Water");
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("  Plz Give Me");
    lcd.setCursor(0, 1);
    lcd.print("     Water   ");
    delay(3000);
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print(" If Anything");
    lcd.setCursor(0, 1);
    lcd.print("  You Want ");


  }

  else if (g <= 670) {
    //Prateek
    //wwww.prateeks.in
    //www.justdoelectronics.com
    //https://www.youtube.com/c/JustDoElectronics/videos
    digitalWrite(green, HIGH);
    digitalWrite(blue, LOW);
    digitalWrite(red, LOW);
    mySerial.println("Plz Give Me Food");
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("  Plz Give Me ");
    lcd.setCursor(0, 1);
    lcd.print("     Food   ");
    delay(3000);
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print(" If Anything");
    lcd.setCursor(0, 1);
    lcd.print("  You Want ");


  }

  else if (h <= 675) {
    digitalWrite(green, HIGH);
    digitalWrite(blue, LOW);
    digitalWrite(red, LOW);
    mySerial.println("Plz Give Me Tea");
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("  Plz Give Me");
    lcd.setCursor(0, 1);
    lcd.print("     Tea   ");
    delay(3000);
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print(" If Anything");
    lcd.setCursor(0, 1);
    lcd.print("  You Want ");
    //Prateek
    //wwww.prateeks.in
    //www.justdoelectronics.com
    //https://www.youtube.com/c/JustDoElectronics/videos

  }

  else {
  }
  delay(200);
}
