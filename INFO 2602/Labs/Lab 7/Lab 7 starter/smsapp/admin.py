from django.contrib import admin

# Register your models here.
from .students import Student

admin.site.register(Student)