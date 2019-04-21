#!/bin/bash

playbook=nxrm3-list-content-selectors

script_name=list_content_selectors

ansible-playbook ../playbooks/${playbook}.yml --extra-vars "script_name=${script_name}"

