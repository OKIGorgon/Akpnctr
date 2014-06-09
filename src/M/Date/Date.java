package M.Date;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date(int d, int m, int y) {
		setDay(d);
		setMonth(m);
		setYear(y);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public boolean notLarger(Date Dat) {
		//if (this.year < Dat.year
		//		|| (this.year == Dat.year && (this.month < Dat.month || (this.month == Dat.month && this.day <= Dat.day)))) {
		//	return true;
		//} else {
		//	return false;
		//}
		
		if(this.year<Dat.year)
			return true;
		if(this.year>Dat.year)
			return false;
		if(this.month<Dat.month)
			return true;
		if(this.month>Dat.month)
			return false;
		if(this.day<=Dat.day)
			return true;
		else return false;
		

	}

	public void Inc(int i) {

		for (; i > 0; i--) {
			this.day++;
			switch (this.month) {
			case 1:
				if (this.day > 31) {
					this.month++;
					this.day = 1;
				}
				break;
			case 2:
				if (this.year % 4 == 0) {
					if (this.year % 100 == 0) {
						if (this.year % 400 == 0) {
							if (this.day > 29) {
								this.month++;
								this.day = 1;
							}
						} else {
							if (this.day > 28) {
								this.month++;
								this.day = 1;
							}
						}
					} else {
						if (this.day > 29) {
							this.month++;
							this.day = 1;
						}
					}
				} else {
					if (this.day > 28) {
						this.month++;
						this.day = 1;
					}
				}

				break;
			case 3:
				if (this.day > 31) {
					this.month++;
					this.day = 1;
				}
				break;
			case 4:
				if (this.day > 30) {
					this.month++;
					this.day = 1;
				}
				break;
			case 5:
				if (this.day > 31) {
					this.month++;
					this.day = 1;
				}
				break;
			case 6:
				if (this.day > 30) {
					this.month++;
					this.day = 1;
				}
				break;
			case 7:
				if (this.day > 31) {
					this.month++;
					this.day = 1;
				}
				break;
			case 8:
				if (this.day > 31) {
					this.month++;
					this.day = 1;
				}
				break;
			case 9:
				if (this.day > 30) {
					this.month++;
					this.day = 1;
				}
				break;
			case 10:
				if (this.day > 31) {
					this.month++;
					this.day = 1;
				}
				break;
			case 11:
				if (this.day > 30) {
					this.month++;
					this.day = 1;
				}
				break;
			case 12:
				if (this.day > 31) {
					this.month = 1;
					this.year++;
					this.day = 1;

				}
				break;
			}
		}
	};

	public void print() {
		System.out.println(this.day);
		System.out.println(this.month);
		System.out.println(this.year);
	}

	public String toString() {
		return Integer.toString(this.getDay()) + "."
				+ Integer.toString(this.getMonth()) + "."
				+ Integer.toString(this.getYear());
	}
}
