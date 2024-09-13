void setup() {
  //Initialize the Serial port on the Arduino to 9600 baud, this number needs to match the baud rate in your robot code
  //Baud rate changes the speed at which you communicate, larger numbers are faster.
  //More information on Arduino baud rates can be found at https://www.arduino.cc/en/serial/begin
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
     
     
     
    }
  }

  //Delay 50 milliseconds, otherwise the loop method runs as fast as possible over and over again which isn't really necessary and can sometimes cause
  //instability in the callbacks used to manage the serial buffers when using higher baud rates. 
  delay(50);
}
