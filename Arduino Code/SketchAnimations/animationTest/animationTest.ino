#include <FastLED.h>

#define LED_PIN     7
#define NUM_LEDS    100

CRGB leds[NUM_LEDS];

void setup() {

  FastLED.addLeds<WS2812, LED_PIN, GRB>(leds, NUM_LEDS);
  Serial.begin(9600);
}







void loop() {
  //If the RoboRIO has sent something
  if(Serial.available()) {
    //Read a byte from the input buffer
    byte value = Serial.read();

    //If the byte is 0x12 (i.e. 18 in decimal)
    if(value == 0x12) {
      //Write a string to the output buffer as a response to send to the RoboRIO

     delay(500);  
  leds[1] = CRGB(255, 255, 255);
  FastLED.show();
  delay(500);
  leds[1] = CRGB(0, 0, 0);
  FastLED.show();
  delay(500);
     
     
    };
  };
  delay(50);
};