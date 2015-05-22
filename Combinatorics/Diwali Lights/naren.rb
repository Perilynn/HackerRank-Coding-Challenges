# Enter your code here. Read input from STDIN. Print output to STDOUT

(0..gets.to_i - 1).each do |i|
    puts ((2 ** gets.to_i) - 1) % (10 ** 5)
end
