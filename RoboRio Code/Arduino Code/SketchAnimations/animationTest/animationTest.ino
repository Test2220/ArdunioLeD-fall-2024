#include <FastLED.h>

#define LED_PIN 7
#define NUM_LEDS 100

CRGB leds[NUM_LEDS];

void setup() {
  Serial.begin(9600);
  FastLED.addLeds<WS2812, LED_PIN, GRB>(leds, NUM_LEDS);
}



void loop() {


    if(Serial.available()) {
    //Read a byte from the input buffer
    byte value = Serial.read();

    //If the byte is 0x12 (i.e. 18 in decimal)
    if(value == 0x12) {
      //Write a string to the output buffer as a response to send to the RoboRIO


      leds[1] = CRGB(0, 10, 0);
      FastLED.show();
      leds[2] = CRGB(0, 10, 0);
      FastLED.show();

    }

     if(value == 0x13) {
      //Write a string to the output buffer as a response to send to the RoboRIO


      leds[1] = CRGB(0, 0, 0);
      FastLED.show();
      leds[2] = CRGB(0, 0, 0);
      FastLED.show();

    }
     if(value == 0x14) {
      //Write a string to the output buffer as a response to send to the RoboRIO


      leds[1] = CRGB(0, 0, 10);
      FastLED.show();
      leds[2] = CRGB(0, 0, 10);
      FastLED.show();

    }
     if(value == 0x15) {
      //Write a string to the output buffer as a response to send to the RoboRIO


      leds[1] = CRGB(10, 0, 0);
      FastLED.show();
      leds[2] = CRGB(10, 0, 0);
      FastLED.show();

    }
  }

}






//   //Delay 50 milliseconds, otherwise the loop method runs as fast as possible over and over again which isn't really necessary and can sometimes cause
//   //instability in the callbacks used to manage the serial buffers when using higher baud rates.
//   delay(50);
// }



// void loop() {
//   for (int dot = (NUM_LEDS - 1); dot >= 0; dot--)

//   {

//     leds[dot] = CRGB::Green;

//     FastLED.show();

//     leds[dot] = CRGB::Black;

//     delay(300);
//   }

//   for (int dot = 0; dot < NUM_LEDS; dot++)

//   {
//     leds[dot] = CRGB::Red;

//     FastLED.show();

//     leds[dot] = CRGB::Black;

//     delay(300);
//   }
// }
