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
  lcd.print("Sign Language - Group06");

  delay(1000);
}

void loop() {
  int flexVal1 = analogRead(flexpin1);
  int flexVal2 = analogRead(flexpin2);
  int flexVal3 = analogRead(flexpin3);
  int flexVal4 = analogRead(flexpin4);
  
  String word = getWordFromFlexValues(flexVal1, flexVal2, flexVal3, flexVal4);

  Serial.println(word);
  
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print(word);

  delay(1000);
}

//Template to work on...
String getWordFromFlexValues(int flex1, int flex2, int flex3, int flex4) {
  // Define thresholds for each flex sensor
  int threshold1 = 500; // Adjust this threshold according to your sensor calibration
  int threshold2 = 500; // Adjust this threshold according to your sensor calibration
  int threshold3 = 500; // Adjust this threshold according to your sensor calibration
  int threshold4 = 500; // Adjust this threshold according to your sensor calibration
  
  // Determine which word corresponds to the flex sensor readings
  if (flex1 > threshold1 && flex2 > threshold2 && flex3 > threshold3 && flex4 > threshold4) {
    return "Happy";
  } else {
    // Add more conditions to cover different words/signs based on flex sensor readings
    return "Unknown";
  }
}
