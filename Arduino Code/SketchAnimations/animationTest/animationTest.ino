#include <FastLED.h>

#define LED_PIN     7
#define NUM_LEDS    3

CRGB leds[NUM_LEDS];

void setup() {
  Serial.begin(9600);
  FastLED.addLeds<WS2812, LED_PIN, GRB>(leds, NUM_LEDS);
}



void loop() {


 leds[1] = CRGB(0, 10, 0);
      FastLED.show();
     leds[2] = CRGB(140, 0, 0);
       FastLED.show();
     leds[3] = CRGB(0, 125, 10);
     FastLED.show();
    leds[4] = CRGB(0, 140, 140);
    FastLED.show();
  leds[5] = CRGB(0, 0, 140);
  FastLED.show();

  delay(100);

  leds[1] = CRGB(0, 0, 0);
  FastLED.show();
  leds[2] = CRGB(0, 0, 0);
  FastLED.show();
  leds[3] = CRGB(0, 0, 0);
  FastLED.show();
  leds[4] = CRGB(0, 0, 0);
  FastLED.show();
  leds[5] = CRGB(0, 0, 0);
  FastLED.show();

  delay(100);




    
  

  //Delay 50 milliseconds, otherwise the loop method runs as fast as possible over and over again which isn't really necessary and can sometimes cause
  //instability in the callbacks used to manage the serial buffers when using higher baud rates. 
  delay(50);
}
