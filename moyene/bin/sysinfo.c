#include <linux/kernel.h>
//#include <linux/sys.h>
#include <stdio.h>
#include <sys/sysinfo.h>

int main(void)
{
    /* Constantes conversores */

    const long minute = 60;
    const long hour = minute * 60;
    const long day = hour * 24;
    const double megabyte = 1024 * 1024;

    /* obter estatistica do sistema */
    struct sysinfo si;
    sysinfo(&si);

    /* Sumario  */
    printf("Sistema acordado: %ld dias, %ld:%02ld:%02ld\n", (si.uptime / day), (si.uptime % day) / hour, 
							(si.uptime % hour) / minute, si.uptime % minute);

    printf("Total Ram : %5.1f MB\n", si.totalram / megabyte);
    printf("Livre Ram : %5.1f MB\n", si.freeram / megabyte);
    printf("Contagem de processo: %d\n", si.procs);

    return 0;

}
