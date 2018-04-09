from django.shortcuts import render
from .students import Student
# Create your views here.

def full_student_listing(request):
    all_students = Student.objects.all()
    return render(request, 'students/list.html', {'students' : all_students})
