
import math


def compute(numerator: int, denominator: int) -> list:
    fractions: list = []
    while numerator > 0:
        x = math.ceil(denominator/numerator)
        fractions.append(x)

        numerator = x * numerator - denominator
        denominator = x * denominator

    return fractions


if __name__ == '__main__':
    print(compute(6, 14))
    print(compute(2, 3))
