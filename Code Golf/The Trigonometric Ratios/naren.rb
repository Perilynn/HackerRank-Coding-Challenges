#SCORE: 15.65
gets;$<.map{|n|f=1;a=[1,0];1.upto(9){|m|a[1],a[0]=a[0],-a[1]+f*=n.to_f/m};p a[0],a[1]}
