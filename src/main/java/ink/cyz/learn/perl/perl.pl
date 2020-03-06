use strict;
use warnings;

my $c="\n";
my @a=split(/#*/,$c);
if ($a[0] eq "\n") {
    pop(@a);
}
print(@a);
print("a");