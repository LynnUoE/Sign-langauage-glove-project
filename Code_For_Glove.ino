#include <Wire.h>
#include "rgb_lcd.h"

rgb_lcd lcd;

const int colorR = 255;
const int colorG = 0;
const int colorB = 0;

int flexpin1 = A0;
int flexpin2 = A1;
int flexpin3 = A2;
int flexpin4 = A3;

void setup() {
  Serial.begin(9600);
  lcd.begin(16, 2);
  lcd.setRGB(colorR, colorG, colorB);
  lcd.print("Sign Language - Group 6");
}

void loop() {
  int flexVal1 = analogRead(flexpin1);
  int flexVal2 = analogRead(flexpin2);
  int flexVal3 = analogRead(flexpin3);
  int flexVal4 = analogRead(flexpin4);
  Serial.println("\tSensor A0: ");
  Serial.println(flexVal1);
  Serial.print("\tSensor A1: ");
  Serial.println(flexVal2);
  Serial.print("\tSensor A2: ");
  Serial.println(flexVal3);
  Serial.print("\tSensor A3: ");
  Serial.println(flexVal4);

  if (flexVal1 > 280 && flexVal1 < 300 && flexVal2 > 130 && flexVal2 < 170 && flexVal3 > 170 && flexVal3 < 240 && flexVal4 < 250 && flexVal4 > 220) {
    lcd.clear();
    lcd.print("Good");
  } else if (flexVal1 > 270 && flexVal1 < 300 && flexVal2 > 110 && flexVal2 < 150 && flexVal3 > 240 && flexVal3 < 260 && flexVal4 > 280 && flexVal4 < 310) {
    lcd.clear();
    lcd.print("Eight");
  } else if (flexVal1 > 260 && flexVal1 < 310 && flexVal2 < 210 && flexVal2 > 190 && flexVal3 > 240 && flexVal3 < 270 && flexVal4 > 180 && flexVal4 < 205) {
    lcd.clear();
    lcd.print("U");
  } else if (flexVal1 > 260 && flexVal1 < 280 && flexVal2 > 160 && flexVal2 < 200  && flexVal3 > 240 && flexVal3 < 270 && flexVal4 > 260 && flexVal4 < 310) {
    lcd.clear();
    lcd.print("Water");
  } else if (flexVal1 > 270 && flexVal1 < 310 && flexVal2 >  130 && flexVal2 < 160 && flexVal3 > 240 && flexVal3 < 280 && flexVal4 > 250 && flexVal4 < 290) {
    lcd.clear();
    lcd.print("Love");
  } else if (flexVal1 > 280 && flexVal1 < 310 && flexVal2 > 170 && flexVal2 < 220 && flexVal3 > 250 && flexVal3 < 290 && flexVal4 > 280 && flexVal4 < 300) {
    lcd.clear();
    lcd.print("Hi");
  } else if (flexVal1 > 270 && flexVal1 < 310 && flexVal2 < 170 && flexVal2 > 130 && flexVal3 > 240 && flexVal3 < 270 && flexVal4 > 220 && flexVal4 < 260) {
    lcd.clear();
    lcd.print("L");
  } else if (flexVal1 > 250 && flexVal1 < 300 && flexVal2 > 140 && flexVal2 < 170 && flexVal3 > 200 && flexVal3 < 230 && flexVal4 > 220 && flexVal4 < 260) {
    lcd.clear();
    lcd.print("A");
  } else if (flexVal1 > 250 && flexVal1 < 280 && flexVal2 > 160 && flexVal2 < 200 && flexVal3 > 170 && flexVal3 < 220 && flexVal4 > 210 && flexVal4 < 250) {
    lcd.clear();
    lcd.print("S");
  } else {
    lcd.clear();
    lcd.print("Waiting...");
  }

  delay(3000);
}
