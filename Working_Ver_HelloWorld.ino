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
//int flexpin2 = A1;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  lcd.begin(16, 2);

  lcd.setRGB(colorR, colorG, colorB);

  // Print a message to the LCD.
  lcd.print("Sign Language - Group 6");

  delay(1000);
}

void loop() {
  // put your main code here, to run repeatedly:
  int flexVal1;
  int flexVal2;
  int flexVal3;
  int flexVal4;
  
  flexVal1 = analogRead(flexpin1);
  flexVal2 = analogRead(flexpin2);
  flexVal3 = analogRead(flexpin3);
  flexVal4 = analogRead(flexpin4);
  
  Serial.print("\tSensor A0: ");
  Serial.println(flexVal1);
  Serial.print("\tSensor A1: ");
  Serial.println(flexVal2);
  Serial.print("\tSensor A2: ");
  Serial.println(flexVal3);
  Serial.print("\tSensor A3: ");
  Serial.println(flexVal4);

  lcd.setCursor(0, 1);
  // print the number of seconds since reset:
  lcd.print(millis() / 1000);
  
  delay(1000);
}
