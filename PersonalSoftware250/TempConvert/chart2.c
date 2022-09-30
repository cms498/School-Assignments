#include <stdio.h>

int main()
{
	puts("Fahrenheit-Celsius");
	double celcius = 0;
	for(int f = 0; f <= 300; f += 20){
		celcius = (5.0*(f - 32))/9.0;
		printf("%6d%11.1f\n", f, celcius);
	}
	return 0;
}
