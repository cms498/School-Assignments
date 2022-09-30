#include <stdio.h>

int main()
{
	puts("Fahrenheit-Celsius");
	int celcius = 0;
	for(int f = 0; f <= 300; f += 20){
		celcius = (5*(f - 32))/9;
		printf("    %-9d%-d\n", f, celcius);
	}
	return 0;
}
