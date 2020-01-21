clear#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

/**
 * @Author Josh
 * @Made 27/9/2019
 * @ProblemSolved filter to clean text.
        remove all characters that are not alphabetic, blank or newline -
        replacing every such character by a blank to keep the number of characters constant to the original text.
 * @HowToUse run with input
 *
 */

int main() 
{

char c;

    while ((c = getchar()) != EOF )
    {
        
        if ( isalpha(c) != 0 || c == '\n' || c == ' ' )
        {
            putchar(c);
        }
        else
        {
            printf("%c", ' ');
        }
        
    }
}
